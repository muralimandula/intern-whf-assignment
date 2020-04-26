<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Laravel</title>

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,600" rel="stylesheet">
        {{-- <link href="{{ asset('css/app.css') }}" rel="stylesheet"> --}}
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">

            <div class="row" style="padding-top:100px">
            
                <div class="col-sm-3" >
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Transactions</h5>
                          <p class="card-text">Trnasaction serach, status update, detail view..</p>
                          <a href="/transactions" class="btn btn-primary">Go to transactions</a>
                        </div>
                    </div>
                </div>

                <div class="col-sm-3" style="padding-left:100px">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                          <h5 class="card-title">Customers</h5>
                          <p class="card-text">Customer serach, status update, detail view..</p>
                          <a href="/customers" class="btn btn-primary">Go to customers</a>
                        </div>
                    </div>
                </div>
            
            </div>

        </div>
    </body>
</html>
