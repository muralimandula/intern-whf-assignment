<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width , initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="{{ asset('css/app.css') }}" rel="stylesheet">
    </head>

    <body>
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a class="navbar-brand" href="/">Ezepay Admin</a></li>
                        <li><a href="/transactions">Transactions</a></li>
                        <li><a href="/customers">Customers</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
        <div class="navbar navbar-collapse">

        </div>
        <div class="container">
            @yield('content')
        </div>
    </body>
    <script src="{{ asset('js/app.js') }}"></script>
</html>