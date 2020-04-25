@extends('master')

@section('content')
<div class="container">
	<h1>Ezepay Customers</h1>	
            <form>
                <div class="form-row">
                    <div class="form-group col-md-12">
                    <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Search by email.." title="Type in a transactionId">
                    </div>
                </div>
            </form>
            
            @if(count($errors) > 0)
                <div class="alert alert-danger">
                    {{-- <p>{{$errors}}</p> --}}
                    <ul>
                        @foreach ($errors->all() as $error)
                                <li>
                                    {{$error}}
                                </li>
                        @endforeach
                    </ul>
                </div>
            @endif

            @if ($message = Session::get('success'))
                <div class="aler alert-success">
                    <p>{{$message}}</p>
                </div>
                
            @endif
            <table id="myTable" class="table">
                <tr>
                    <th>Customer Id</th>
                    <th>Name</th>
                    <th>Contact</th>
                    <th>Email</th>
                </tr>
                @foreach ($allCustomers as $eachCustomer)
                    <form action={{action('CustomerController@edit', $eachCustomer['customer_id'])}} method="POST">
                        {{ csrf_field() }}
                        {{-- PATCH method instead of PUT, will see later --}}
                        <input type="hidden" name="_method"  value="PATCH"/>
                        <tr>
                            <td>{{$eachCustomer['customer_id']}}</td>
                            <td>{{$eachCustomer['first_name']}}</td>
                            <td>{{$eachCustomer['contact']}}</td>
                            <td>{{$eachCustomer['email']}}</td>
                            <td>
                                <input type="submit" class="btn btn-primary" value="Update"/>    
                            </td>
                        </tr>
                    </form>
                @endforeach
            </table>
        </div>

        <script>
            function myFunction() {
                var input, filter, table, tr, emailId, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    emailId = tr[i].getElementsByTagName("td")[3];
                    
                    if (emailId) {
                        txtValue = (emailId.textContent || emailId.innerText) ;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }       
                }
            }
        </script>
@endsection