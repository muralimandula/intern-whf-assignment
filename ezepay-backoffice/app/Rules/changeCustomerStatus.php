<?php

namespace App\Rules;

use Illuminate\Contracts\Validation\Rule;

class changeCustomerStatus implements Rule
{
    protected $areStatusSame = false;
    protected $customer;


    /**
     * Create a new rule instance.
     *
     * @return void
     */
    public function __construct($customer, $req)
    {
        $this->customer = $customer;
        $this->areStatusSame = ($customer['status'] == $req['customerStatus']);
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
        //return 
        return ($value != 'Change status') and (!$this->areStatusSame);
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        if($this->areStatusSame) {
            return 'Customer status is already in '.$this->customer['status'];
        }
        return 'Please select status.';
    }
}
