<%--
  Created by IntelliJ IDEA.
  User: toank
  Date: 30/08/2024
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.wcd.Entity.Player" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Class room</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
          integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
          integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
          crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
          integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
          crossorigin="anonymous"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>

<header>
  <%@ include file="../../include/header.jsp" %>
</header>

<body>
<div>
  <h3>Add player</h3>
  <form action="player" method="post">
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">Player name</span>
      </div>
      <input type="text" id="name" name="name" class="form-control" aria-label="Class name" aria-describedby="inputGroup-sizing-default">
    </div>
    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text">Index</span>
      </div>
      <input type="number" id="index_id" name="index_id" class="form-control" aria-label="Number" aria-describedby="inputGroup-sizing-default">
    </div>
    <button class="btn btn-primary" type="submit">Add</button>
  </form>
</div>
<table>
  <thead>
  <th>Id</th>
  <th>Player name</th>
  <th>Player age</th>
  <th>Index name</th>
  <th>Value</th>
  </thead>
  <tbody>
  <%
    List<Player> players = (List<Player>) request.getAttribute("classRooms");
    for (Player player : players) {
  %>
  <tr role="row">
    <td><%= Player.getPlayer_id()%></td>
    <td><%= Player.getName()%></td>
    <td><%= Player.getIndex_id()%></td>
    <td>
      <div style="display: flex; gap: 10px;">
        <form action="player" method="post">
          <input type="hidden" name="_method" value="DELETE">
          <input type="hidden" name="id" value= "<%=Player.getPlayer_id()%>">
          <button type="submit" class="btn btn-danger">Delete</button>
        </form>
        <form action="player" method="post">
          <input type="hidden" name="_method" value="PUT">
          <button type="submit" class="btn btn-primary">Edit</button>
        </form>
      </div>
    </td>
  </tr>
  <%
    }%>
  </tbody>
</table>
</body>

</html>

