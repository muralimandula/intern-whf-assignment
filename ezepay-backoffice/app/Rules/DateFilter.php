<?php

namespace App\Rules;

use Illuminate\Contracts\Validation\Rule;

class DateFilter implements Rule
{

    protected $fromToDate;
    /**
     * Create a new rule instance.
     *
     * @return void
     */
    public function __construct($fromToDate)
    {
        //
        $this->fromToDate = $fromToDate;
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
        // $value is the field value on which Validation applied
        // still we can use request object passed on (i.e., $fromToDate)

        return $this->fromToDate['fromDate'] <= $this->fromToDate['toDate'];
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        return 'Select proper dates : From ' . $this->fromToDate['fromDate']  .' to ' . $this->fromToDate['toDate'] . ' not Applicable.' ;
    }
}
