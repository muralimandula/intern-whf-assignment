@extends('master')

@section('content')

	<div class="container">

		<div class="card">

			<div class="card-header">
				<h2> Tnx Id: <strong>{{$transaction['transaction_id']}}</strong>  </h2>
			</div>

			<div class="card-header">
				<h4>Tnx Date: <strong>{{$transaction['created_at']}}</strong></h4>
			</div>

			<br>
			
			<div class="card-body">

				<div class="row mb-4">

					<div class="col-sm-3">
						<h5 class="mb-3">From:</h5>
							<div>
								<h3><strong>{{$transaction['customer_name']}}</strong></h3>
							</div>
							<div>
								<h4>{{$transaction['customer_contact']}}</h4>
							</div>
					</div>

					<div class="col-sm-3">
						<h5 class="mb-3">To:</h5>
							<div>
								<h3><strong>{{$transaction['merchant_name']}}</strong></h3>
							</div>
					</div>
				</div>

				<br>

				<div class="table-responsive-sm">

					<table class="table table-striped">
						
						<tr>
							<th>Transaction Id</th>
							<td>{{$transaction['transaction_id']}}</td>
						</tr>
						<tr>
							<th>Reference Id</th>
							<td>{{$transaction['reference_id']}}</td>
						</tr>
						<tr>
							<th>Merchant Req Id</th>
							<td>{{$transaction['merchant_request_id']}}</td>
						</tr>
						<tr>
							<th>Customer</th>
							<td>{{$transaction['customer_name']}}</td>
						</tr>
						<tr>
							<th>Merchant</th>
							<td>{{$transaction['merchant_name']}}</td>
						</tr>
						<tr>
							<th>Date</th>
							<td>{{$transaction['created_at']}}</td>
						</tr>
						<tr>
							<th>Currency</th>
							<td>{{$transaction['currency']}}</td>
						</tr>
						<tr>
							<th>Amount</th>
							<td>{{$transaction['amount']}}</td>
						</tr>
						<tr>
							<th>Staus</th>
							<td>{{$transaction['status']}}</td>
						</tr>
						<tr>
							<th>Response</th>
							<td>{{$simulatorResponse['message']}}</td>
						</tr>
					</table>
				</div>

				<button onclick=window.history.back() class="btn btn-primary">Go Back</button>
			</div>
		</div>
	</div>
@endsection