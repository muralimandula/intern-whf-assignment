<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Transaction extends Model
{
    //
    protected $table = 'transaction';
    protected $primaryKey = 'transaction_id'; //Helps Laravel to recognize given column as primaryKey
    public $timestamps = false;               // For my table convention, as I don't want migrate timestamps() into existing table
}
