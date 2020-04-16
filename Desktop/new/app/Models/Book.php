<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Book extends Model
{
    protected $table = 'books';

    public $primaryKey = 'id';
    public $timestamps = true;

    protected $fillable = [
        'name',
        'loaisach_id',
        'desc',
        'image',
    ];

    protected $perPage = 5;

    public function saveBook($request)
    {
        $data = $request->all();

        if ($request->hasFile('image')) {
            $clientImageName = pathinfo($request->image->getClientOriginalName(), PATHINFO_FILENAME);
            $clientImageExtension = $request->image->getClientOriginalExtension();
            $data['image'] = $clientImageName . '_' . time() . '.' . $clientImageExtension;

            $request->file('image')->storeAs('public/book_images', $data['image']);
        } else {
            $data['image'] = null;
        }

        Book::create($data);
    }

    public function updateBook($request)
    {
        $data = $request->all();

        if ($request->hasFile('image')) {
            $clientImageName = pathinfo($request->image->getClientOriginalName(), PATHINFO_FILENAME);
            $clientImageExtension = $request->image->getClientOriginalExtension();
            $data['image'] = $clientImageName . '_' . time() . '.' . $clientImageExtension;

            $request->file('image')->storeAs('public/book_images', $data['image']);
        } else {
            $data['image'] = $this->find($request->id)->image;
        }

        return $this->find($request->id)->update($data);
    }

    public function findLoaisach($id)
    {
        return $this->orderBy('name')->with('loaisach')->where('loaisach_id',$id);
    }

    public function loaisach()
    {
        return $this->belongsTo('App\Models\Loaisach');
    }
}
