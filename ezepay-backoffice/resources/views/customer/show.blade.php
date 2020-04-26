@extends('master')

@section('content')

	<div class="container">

		<div class="card">

			<div class="card-header">
				<h3> Customer Id: <strong>{{$customer['customer_id']}}</strong>  </h3>
			</div>

			
			<div class="card-body">

				<div class="row mb-4">

					<div class="col-sm-6">
						<div>
							<h4><strong>{{$customer['first_name']}} {{$customer['last_name']}}</strong></h4>
						</div>
						<div>{{$customer['city']}}</div>
						<div>{{$customer['state']}}, {{$customer['country']}}</div>
						<div>{{$customer['zip']}}</div>
					</div>
				</div>

				<br>

				<div class="table-responsive-sm">

					<table class="table table-striped">
						<thead>
							<tr>
								<th>Customer Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Contact</th>
								<th>DOB</th>
								<th>Staus</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>{{$customer['customer_id']}}</td>
								<td>{{$customer['first_name']}}</td>
								<td>{{$customer['last_name']}}</td>
								<td>{{$customer['email']}}</td>
								<td>{{$customer['contact']}}</td>
								<td>{{$customer['dob']}}</td>
								<td>{{$customer['status']}}</td>
							</tr>
						</tbody>
					</table>
				</div>

				<a href="/customers" class="btn btn-primary">Go Back</a>
			</div>
		</div>
	</div>
@endsection