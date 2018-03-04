<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html ng-app="AppAll">
<head>
    <title>Spring gulp rev cdn Demo</title>

    <!-- build:cssLibIndex ../static/styles/external-all.css -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- endbuild -->
    <!-- build:cssAppIndex ../static/styles/app-all.css -->
    <link href="../app/styles/main.css" rel="stylesheet" media="screen"/>
    <!-- endbuild -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
</head>
<body ng-controller="AppAll.AppCtrl">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li ng-class="{'active': currentUrl == 'view1'}" ng-click="switchView('view1')"><a href="#/view1">视图1</a></li>
                    <li ng-class="{'active': currentUrl == 'view2'}" ng-click="switchView('view2')"><a href="#/view2">视图2</a></li>
                    <li ng-class="{'active': currentUrl == 'view3'}" ng-click="switchView('view3')"><a href="#/view3">视图3</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">墨荷琼林-----|</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="container">
        <div ng-view autoScroll="true"></div>
    </div>

<!-- build:jsLibIndex ../static/js/lib-all.js -->
    <script type="text/javascript" src="../bower_components/jquery/dist/jquery.min.js"></script>
    <script type="text/javascript" src="../bower_components/angular/angular.min.js"></script>
    <script type="text/javascript" src="../bower_components/angular-cookies/angular-cookies.js"></script>
    <script type="text/javascript" src="../bower_components/lodash/lodash.min.js"></script>
    <script type="text/javascript" src="../bower_components/angular-filter/dist/angular-filter.min.js"></script>
    <script type="text/javascript" src="../bower_components/angular-resource/angular-resource.js"></script>
    <script type="text/javascript" src="../bower_components/angular-route/angular-route.js"></script>

<!-- endbuild -->

<!-- build:appJs ../static/js/app-all.js -->
    <script type="text/javascript" src="../app/app.js"></script>
    <script type="text/javascript" src="../app/appCtrl.js"></script>
    <script type="text/javascript" src="../app/view1/view1Module.js"></script>
    <script type="text/javascript" src="../app/view1/view1Ctrl.js"></script>
    <script type="text/javascript" src="../app/view2/view2Module.js"></script>
    <script type="text/javascript" src="../app/view2/view2Ctrl.js"></script>
    <script type="text/javascript" src="../app/view3/view3Module.js"></script>
    <script type="text/javascript" src="../app/view3/view3Ctrl.js"></script>
<!-- endbuild -->

<script type="text/javascript" src="http://g.alicdn.com/ilw/ding/0.8.6/scripts/dingtalk.js"></script>

</body>
</html>
