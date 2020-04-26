<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Transaction;

class TransactionController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
        $allTransactions =  Transaction::all()->toArray();

        return view('transaction.index', compact('allTransactions'));  // View from folder   resources/views/transaction
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
        return view('transaction.show', compact('transaction'));
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
        // Giving validation to the fields in th form(form that calls this method)
        // $this->validate($request, [
        //     'newStatus' => 'required|changeStatusValidator',
        // ]);

        $transaction = Transaction::find($id);  // reads as find(id) | If primaryKey column name is not 'id' should mention column_name in Model

        $transaction['status'] = $request->get('newStatus');

        $transaction->save();

        // Uses  route from routes/web.php       
        // Route::resource('transactions', 'TransactionController'); "transactions" is usage name of TransactionController
        //
        return redirect()
                        ->route('transactions.index')
                        ->with('success', 'Updated successfully');   // calling index() method from Route,"transactions" (i.e., TransactionController)

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