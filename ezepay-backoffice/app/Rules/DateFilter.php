<?php

namespace App\Rules;

use Illuminate\Contracts\Validation\Rule;

class DateFilter implements Rule
{

    protected $fromToDate;
    protected $isValidSearch;
    /**
     * Create a new rule instance.
     *
     * @return void
     */
    public function __construct($fromToDate)
    {
        //
        $this->fromToDate = $fromToDate;
        $this->isValidSearch = $this->fromToDate['fromDate'] <= $this->fromToDate['toDate'];
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

        return $this->isValidSearch;
    }

    /**
     * Get the validation error message.
     *
     * @return string
     */
    public function message()
    {
        if (!$this->isValidSearch) {
            return 'Select proper dates : From ' . $this->fromToDate['fromDate']  .' to ' . $this->fromToDate['toDate'] . ' not Applicable.' ;
        }
    }
}
