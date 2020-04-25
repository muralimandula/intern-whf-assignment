<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Customer extends Model
{
    //
    protected $table = 'customer';
    protected $primaryKey = 'customer_id'; //Helps Laravel to recognize given column as primaryKey
    public $timestamps = false;               // For my table convention, as I don't want migrate timestamps() into existing table
}
