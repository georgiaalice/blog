<!DOCTYPE html>
<html>
    <head>
        <#include "header.ftl">
    </head>
    <body>
        <#include "nav.ftl">
        <div class="jumbotron text-center">
            <div class="container">
                <h1>My Blog</h1>
                <p>This is my blog.</p>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h3>Blog Posts</h3>
                    <ul>
			<#list posts as post>
			<li><a href="/posts/${post}/">${post?replace("_", " ")}</a></li>
			</#list>
                    </ul>
            </div>
          </div>
        </div>
    </body>
</html>
