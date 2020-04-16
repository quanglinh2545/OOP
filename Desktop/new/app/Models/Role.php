<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Role extends Model
{
    protected $table = 'roles';

    public $primaryKey = 'id';
    public $timestamps = true;

    protected $fillable = [
        'name',
    ];
}
