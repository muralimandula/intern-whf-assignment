@extends('master')

@section('content')
<div class="container">
    <h1>Ezepay Transactions</h1>
            <div class="row">
                <form>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="searchById">Search By Tnx Id:</label>
                            <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Search by transaction Id.." title="Type in a transactionId">
                        </div>

                        
                        <form>
                            <div class="form-group col-md-3">
                                <label for="fromDate">From</label>
                                <input type="date" name="fromDate" id="picker" class="form-control">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="toDate">To</label>
                                <input type="date" name="toDate" id="picker" class="form-control">
                            </div>
                            <div class="form-group col-md-1" style="padding-top:26px">
                                <input type="submit" value="GO" class="btn btn-primary">
                            </div>
                        </form>

                    </div>
                </form>
            </div>
            
            <div class="row">
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

            </div>


            @if ($message = Session::get('success'))
                <div class="aler alert-success">
                    <p>{{$message}}</p>
                </div>
            @endif

            <div>
                <i><h4>----{{$recordsStatus}}-----</h4></i>
            </div>
            <table id="myTable" class="table">
                <tr>
                    <th>Transaction Id</th>
                    <th>Merchant Req Id</th>
                    <th>Currency</th>
                    <th>Amount</th>
                    <th>Merchant Currency</th>
                    <th>Final Amount </th>
                    <th>Date</th>
                    <th>
                        <select  onchange="myStatusFilter(this);">
                            <option selected>All status</option>
                            <option value="Completed">Completed</option>
                            <option value="Initiated">Initiated</option>
                            <option value="SUCCESS">SUCCESS</option>
                            <option value="FAILED">FAILED</option>
                            <option value="Refund">Refund</option>
                            <option value="Chargeback">Chargeback</option>
                            <option value="Blocked">Blocked</option>

                        </select>
                    </th>
                    <th>Detail View</th>
                    <th>Update status</th>
                    <th>------</th>
                </tr>
                @foreach ($allTransactions as $eachTransaction)
                    <form action={{action('TransactionController@update', $eachTransaction['transaction_id'])}} method="POST">
                        {{ csrf_field() }}
                        {{-- PATCH method instead of PUT, will see later --}}
                        <input type="hidden" name="_method"  value="PATCH"/>
                        <tr>
                            <td>{{$eachTransaction['transaction_id']}}</td>
                            <td>{{$eachTransaction['merchant_request_id']}}</td>
                            <td>{{$eachTransaction['currency']}}</td>
                            <td>{{$eachTransaction['amount']}}</td>
                            <td>{{$eachTransaction['to_currency']}}</td>
                            <td>{{$eachTransaction['final_amount']}}</td>
                            <td>{{$eachTransaction['created_at']}}</td>
                            <td>{{$eachTransaction['status']}}</td>
                            
                            <td><a href="{{action('TransactionController@show', $eachTransaction['transaction_id'])}}" class="btn btn-primary">View</a></td>
                            <td>
                                <select name="newStatus" class="browser-default custom-select">
                                    <option selected>Change status</option>
                                    <option value="Completed">Completed</option>
                                    <option value="Initiated">Initiated</option>
                                    <option value="SUCCESS">SUCCESS</option>
                                    <option value="FAILED">FAILED</option>
                                    <option value="Refund">Refund</option>
                                    <option value="Chargeback">Chargeback</option>
                                    <option value="Blocked">Blocked</option>
                                </select>
                            </td>
                            <td>
                                <input type="submit" class="btn btn-warning" value="Update"/>    
                            </td>
                        </tr>
                    </form>
                @endforeach
            </table>
            {{-- below is to paginate the array of transactions set as paginate(n) : n records per page --}}
            {{-- {{ $allTransactions->links() }} --}}
        </div>

        <script>
            function myFunction() {
                var input, filter, table, tr, transactionId, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    transactionId = tr[i].getElementsByTagName("td")[0];
                    
                    if (transactionId) {
                        txtValue = (transactionId.textContent || transactionId.innerText) ;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }       
                }
            }

            
        </script>
        
        <script>
            function myStatusFilter(filter) {
                var table, tr, recordStatus, i, txtValue;
                // input = document.getElementById("myStatusFilter");  // For '<select> <option></option> </select>' value cannot be obtained by document.getElementById('id')
                filter = filter.value.toUpperCase();
                // alert(filter);
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    recordStatus = tr[i].getElementsByTagName("td")[4];

                    if(filter == 'ALL STATUS') {
                        tr[i].style.display = "";
                    }
                    
                    else if (recordStatus) {
                        txtValue = (recordStatus.textContent || recordStatus.innerText);
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                    else {
                        
                    }
                } 
            }
        </script>
@endsection