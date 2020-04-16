@extends('layouts.default')

@section('title', 'Add Book')

@section('content')
    <br>
    <h1>Add Book</h1>
    <form action="{{ route('books.store') }}" method="post" enctype="multipart/form-data">
        @csrf
        @include('books.form')
        <div class="form-group">
            <button type="submit" class="btn btn-primary">ADD BOOK</button>
        </div>
    </form>

@endsection
