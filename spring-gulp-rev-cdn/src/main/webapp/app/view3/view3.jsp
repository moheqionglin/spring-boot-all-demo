<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="container">
    <h1>{{title}}</h1>
    <div class="table-responsive">
        <table class="table table-bordered table-striped responsive-utilities">
            <thead>
            <tr>
                <th></th>
                <th>
                    超小屏幕
                    <small>手机 (&lt;768px)</small>
                </th>
                <th>
                    小屏幕
                    <small>平板 (≥768px)</small>
                </th>
                <th>
                    中等屏幕
                    <small>桌面 (≥992px)</small>
                </th>
                <th>
                    大屏幕
                    <small>桌面 (≥1200px)</small>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row"><code>.visible-xs-*</code></th>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
            </tr>
            <tr>
                <th scope="row"><code>.visible-sm-*</code></th>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
            </tr>
            <tr>
                <th scope="row"><code>.visible-md-*</code></th>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
            </tr>
            <tr>
                <th scope="row"><code>.visible-lg-*</code></th>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
            </tr>
            </tbody>
            <tbody>
            <tr>
                <th scope="row"><code>.hidden-xs</code></th>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
            </tr>
            <tr>
                <th scope="row"><code>.hidden-sm</code></th>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
            </tr>
            <tr>
                <th scope="row"><code>.hidden-md</code></th>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
                <td class="is-visible">可见</td>
            </tr>
            <tr>
                <th scope="row"><code>.hidden-lg</code></th>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
                <td class="is-visible">可见</td>
                <td class="is-hidden">隐藏</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>