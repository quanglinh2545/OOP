<?php
namespace App\Models;
use Illuminate\Database\Eloquent\Model;
class Nhaxuatban extends Model
{
    //
	protected $table = 'NhaxuatbanTable';
	
	public $timestamps = true;
	
	protected $fillable = [
		'id',
		'ten',
		'diachi',
		'sdt',
		'email',
        'website'
	];
}
