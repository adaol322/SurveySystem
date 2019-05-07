<%--
  Created by IntelliJ IDEA.
  User: Kappa123
  Date: 2019-04-27
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
          crossorigin="anonymous">

    <title>$Title$</title>
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
    <div class="container">
        <a class="navbar-brand" href="#">System Ankiet</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
                <button class="btn btn-dark" data-toggle="modal" data-target="#loginModal">Login</button>
            </li>
            <li class="nav-item">
                <button class="btn btn-dark" data-toggle="modal" data-target="#registerModal">Register</button>
            </li>
        </ul>
    </div>
</nav>

<div class="container">

    <div class="jumbotron text-center">
        <h1 class="display-4">System Ankietowania</h1>
        <p class="lead">asdf123</p>
        <hr>
        <p>Weszła kaczka do wody i się utopiła.</p>
        <a class="btn btn-primary btn-lg" href="#" role="button">Przejdź do wyboru ankiety.</a>
    </div>

    <br>

</div>



<div class="modal" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Logowanie</h5>
                <button class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <input type="text" placeholder="Nazwa użytkownika" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Hasło" class="form-control">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-dismiss="modal">Zaloguj</button>
            </div>
        </div>
    </div>
</div>
</div>

<div class="modal" id="registerModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Rejestracja</h5>
                <button class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <input type="text" placeholder="Nazwa użytkownika" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Hasło" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Powtórz hasło" class="form-control">
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <input type="text" placeholder="Imię" class="form-control">
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <input type="text" placeholder="Nazwisko" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Adres Email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Kierunek" class="form-control">
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <input type="text" placeholder="Semestr" class="form-control">
                                </div>
                            </div>
                            <div class="col">
                                <div class="form-group">
                                    <input type="text" placeholder="Grupa Dziekańska" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" data-dismiss="modal">Zarejestruj</button>
            </div>
        </div>
    </div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>
