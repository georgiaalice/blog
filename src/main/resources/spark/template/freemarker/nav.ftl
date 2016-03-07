<nav class="navbar navbar-default navbar-static-top navbar-inverse">
  <div class="container">
    <ul class="nav navbar-nav">
      <li class="active">
        <a href="/"><span class="glyphicon glyphicon-home"></span> Home</a>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Blog Posts <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
	    <#list posts as post>
	    <li><a href="/posts/${post}/">${post}</a></li>
	    </#list>
          </ul>
      </li>
    </ul>
  </div>
</nav>
