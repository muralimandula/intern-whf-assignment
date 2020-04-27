<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Response extends Model 
{
    //
    protected $table = 'payment_response_body';
    protected $primaryKey = 'reference_id'; //Helps Laravel to recognize given column as primaryKey
    //
}
