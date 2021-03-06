<?php

use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('master');
});

Route::resource('/transactions', 'TransactionController');    // ('endpoint', 'corresponding controller)
Route::resource('/customers', 'CustomerController');        // https://laravel.com/docs/5.0/controllers#restful-resource-controllers