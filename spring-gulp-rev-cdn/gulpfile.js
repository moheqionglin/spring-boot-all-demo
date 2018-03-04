/**
 *   gulp 功能
 *
 *   1、 编译 sass --> css --> 文件合并 --> css文件压缩 --> 添加 sourcemap
 *   2、 js --> 合并 --> 格式校验 --> 压缩 --> 添加sourcemap
 *   3、 为 打包成war包做准备
 *   **********************************
 *         3.1 打包的时候 maven插件会把 webapp 的工程拷贝到 target 的 {项目工程名称}/ 目录中
 *         3.2 我们把 css依赖的所有 font 字体文件 拷贝到 target对应的目录中去
 *         3.3 对 jsp中的 引入的 js做合并压缩处理
 *         3.4 对 jsp中压缩合并处理结束以后的文件打上 version， 防止cdn重名
 *         3.5 用打完version以后的js文件替换jsp中的引用文件名
 *         3.6 修改 所有js中的 引入的资源文件的路径为 CDN路径
 *
 * */


'use strict';
const gulp = require('gulp');
const sourceMap = require('gulp-sourcemaps');
const sass = require('gulp-sass');
const jshint = require('gulp-jshint');
const stylish = require('jshint-stylish');
const useMin = require('gulp-usemin');
const minifyCss = require('gulp-minify-css');
const ngMin = require('gulp-ng-annotate');
const ugLify = require('gulp-uglify');
const gulpUtil = require('gulp-util');
const rev = require('gulp-rev');
const filter = require("gulp-filter");
const revReplace = require("gulp-rev-replace");
const cdnizer = require("gulp-cdnizer");
const CDN = 'http://127.0.0.1:13102/';
//1、 编译 sass --> css --> 文件合并 --> css文件压缩
gulp.task('convert-compress-sass', function(){
    return gulp.src('src/main/webapp/sass/*.scss')
        .pipe(sourceMap.init())
        .pipe(sass())
        .pipe(sourceMap.write('./'))
        .pipe(gulp.dest('src/main/webapp/app/styles/'));
});

//2、 js --> 合并 --> 格式校验
gulp.task('scripts', function () {
    return gulp.src('app/**/*.js', {cwd: 'src/main/webapp/'})
        .pipe(jshint())
        .pipe(jshint.reporter(stylish));
});
//copy 字体
gulp.task('copy-fonts', function () {
    return gulp.src(['src/main/webapp/bower_components/bootstrap/dist/fonts/*.{ttf,woff,woff2,eot,svg}'])
    // .pipe(flatten())
        .pipe(gulp.dest('target/spring-gulp-rev-cdn/static/fonts/'));
});
//3、 为 打包成war包做准备, 压缩jsp中的css和js
gulp.task('usemin', ['copy-fonts', 'scripts', 'convert-compress-sass'], function () {
    return gulp.src('**/*.jsp', {cwd: 'src/main/webapp/'})
        .pipe(useMin({
            cssLibIndex: [minifyCss({processImport: false})],
            cssAppIndex: [minifyCss()],
            jsLibIndex: [ngMin(), ugLify()],
            appJs: [ngMin(), ugLify().on('error', gulpUtil.log)]
        }))
        .pipe(gulp.dest('target/spring-gulp-rev-cdn/'));
});


gulp.task('cdnify', ['usemin'], function () {
    var cssFilter = filter('**/*-all.css', {restore: true});
    var jsFilter = filter('**/*-all.js', {restore: true});
    return gulp.src(['target/spring-gulp-rev-cdn/static/js/*.js', 'target/spring-gulp-rev-cdn/static/styles/*.css', 'target/spring-gulp-rev-cdn/app/index.jsp'])
        .pipe(jsFilter)
        .pipe(rev())
        .pipe(jsFilter.restore)
        .pipe(gulp.dest('target/spring-gulp-rev-cdn/static/js/'))
        .pipe(cssFilter)
        .pipe(rev())
        .pipe(cssFilter.restore)
        .pipe(gulp.dest('target/spring-gulp-rev-cdn/static/styles/'))
        .pipe(revReplace({replaceInExtensions: ['.jsp']}))
        .pipe(cdnizer({
            defaultCDNBase: CDN ,
            relativeRoot: '/',
            files: [
                // {
                // 	//ignore this file, otherwise it tries to map this to our cdn, which breaks the url
                // 	file: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js',
                // 	cdn: 'http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js'
                // },
                '**/*-all-*.css',
                '**/lib-all-*.js',
                '**/app-all-*.js'
            ]}
        ))
        .pipe(gulp.dest("target/spring-gulp-rev-cdn/app/"));
});