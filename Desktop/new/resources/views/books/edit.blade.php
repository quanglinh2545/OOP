@extends('layouts.default')

@section('title', 'edit book')

@section('content')
    <br>
    <h1>Edit Book</h1>
    <form action="{{ route('books.update', $book->id) }}" method="post" enctype="multipart/form-data">
        @csrf
        @method('PUT')
        <input type="hidden" name="id" value="{{ $book->id }}">

        @include('books.form')
        <div class="form-group">
            <button type="submit" class="btn btn-primary">EDIT BOOK</button>
        </div>
    </form>

@endsection
