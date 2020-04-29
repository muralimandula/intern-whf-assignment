<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Transaction;
use App\Response;
use App\Rules\changeTransactionStatus;
use App\Rules\DateFilter;

class TransactionController extends Controller
{

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index(Request $request)
    {   
        
        if (!$request->has('fromDate')) {            //if NO date filter request made, means no keys available : Deafult List

            // $allTransactions = Transaction::whereBetween('created_at',[date('Y-m-d')." 00:00:01", date('Y-m-d')." 23:59:59"])->get();
            // Both brings records created on current date(today).
            $allTransactions = Transaction::where('created_at',"LIKE", date('Y-m-d') . "%")->get();
            
            $recordsStatus = 'Fetching all Records: ' . count($allTransactions) . ' found today! ' . date('Y-m-d');
            // $allTransactions =  Transaction::paginate(8);                   // to show 8 transactions per page, will create a link
        } else {

            $this->validate($request, [
                'fromDate' => 'required',
                'toDate' => ['required',  new DateFilter($request)]
            ]);

            $start = date("Y-m-d",strtotime($request->get('fromDate')));
            $end = date("Y-m-d",strtotime($request->get('toDate')."+1 day")); // TO include toDate in the result

            $allTransactions = Transaction::whereBetween('created_at', [$start, $end])->get();
            $recordsStatus = count($allTransactions) . ' record/s found between ' . $request->get('fromDate') . ' and ' . $request->get('toDate');
        }
        
        return view('transaction.index', compact('allTransactions', 'recordsStatus'));  // View from folder   resources/views/transaction
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
        $transaction = Transaction::find($id);

        $simulatorResponse = Response::find($transaction['reference_id']);  // custom model, Response
        if($simulatorResponse == null) {
            $simulatorResponse = Response::find(0);
        }
        return view('transaction.show', compact('transaction', 'simulatorResponse'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //

    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $transaction = Transaction::find($id);  // reads as find(id) | If primaryKey column name is not 'id' should mention column_name in Model

        // Giving validation to the fields in th form(form that calls this method)
        $this->validate($request, [
            'newStatus' => [new changeTransactionStatus($transaction, $request)],
        ]);

        $transaction['status'] = $request->get('newStatus');

        $transaction->save();

        // Uses  route from routes/web.php       
        // Route::resource('transactions', 'TransactionController'); "transactions" is usage name of TransactionController
        //
        return redirect()
                        ->route('transactions.index')               // calling index() method from Route,"transactions" (i.e., TransactionController)
                        ->with('success', 'Updated successfully');   

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        //
    }
}
?>