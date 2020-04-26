<?php

namespace App\Rules;

use Illuminate\Contracts\Validation\Rule;

class changeTransactionStatus implements Rule
{
    protected $transaction;
    protected $areStatusSame;
    /**
     * Create a new rule instance.
     *
     * @return void
     */
    public function __construct($transaction, $req)
    {
        //
        $this->transaction = $transaction;
        $this->areStatusSame = ($transaction['status'] == $req['newStatus']);
    }

    /**
     * Determine if the validation rule passes.
     *
     * @param  string  $attribute
     * @param  mixed  $value
     * @return bool
     */
    public function passes($attribute, $value)
    {
        //
        return ($value != 'Change status') and !($this->areStatusSame) ;
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        if($this->areStatusSame) {
            return 'Transaction status is already in '.$this->transaction['status'];
        }
        return 'Please select status.';
    }
}
