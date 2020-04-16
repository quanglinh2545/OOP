<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class tacgia extends Model
{
    //
	protected $table = 'tacgias';
	
	public $timestamps = true;
	
	protected $fillable = [
		'id',
		'name',
		'email',
		'phone',
		'address'
	];
}
