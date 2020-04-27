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
				<br>
				
				<div class="table-responsive-sm">

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Transaction Id</th>
								<th>Reference Id</th>
								<th>Merchant Req Id</th>
								<th>Customer</th>
								<th>Merchant</th>
								<th>Date</th>
								<th>Currency</th>
								<th>Amount</th>
								<th>Staus</th>
								<th>Response</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>{{$transaction['transaction_id']}}</td>
								<td>{{$transaction['reference_id']}}</td>
								<td>{{$transaction['merchant_request_id']}}</td>
								<td>{{$transaction['customer_name']}}</td>
								<td>{{$transaction['merchant_name']}}</td>
								<td>{{$transaction['created_at']}}</td>
								<td>{{$transaction['currency']}}</td>
								<td>{{$transaction['amount']}}</td>
								<td>{{$transaction['status']}}</td>
								<td>{{$simulatorResponse['message']}}</td>
							</tr>
						</tbody>
					</table>
				</div>

				<a href="/transactions" class="btn btn-primary">Go Back</a>
			</div>
		</div>
	</div>
@endsection