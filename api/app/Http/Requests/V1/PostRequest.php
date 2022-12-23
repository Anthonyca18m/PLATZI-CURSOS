<?php

namespace App\Http\Requests\V1;

use Illuminate\Foundation\Http\FormRequest;

class PostRequest extends FormRequest
{

    public function authorize()
    {
        return ($this->user()->id == 1);
    }

    public function rules()
    {
        return [
            'user_id' => 'required|exists:users:id',
            'title' => 'required',
            'content' => 'required'
        ];
    }

    public function messages()
    {
        return [
           'title.required' => 'akjnsdjibasnidjkasd'
        ];
    }
}
