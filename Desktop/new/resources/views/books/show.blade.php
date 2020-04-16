@extends('layouts.default')

@section('title', $book->name . ' book')

@section('content')
    <div class="col-md-8 col-sm-8">
        <br>
        @if($book->image)
            <img style="width: 100%" src="/storage/book_images/{{ $book->image }}">
        @else
            <img style="width: 70%" src="/img/no_image.jpg">
        @endif
    </div>
    <br>
    <h1>{{ $book->name }}</h1>
    <br>
    <h4> Describe</h4>
    <p>{!! $book->desc !!}</p>

    <hr>
    <small>written on {{ $book->created_at }}</small>
    <hr>

    @canany(['admin','staff'])
        <a class="btn btn-primary" href="{{ route('books.edit', $book->id) }}">Edit</a>
        <form action="{{ route('books.destroy', $book->id) }}" method="post">
            @csrf
            @method('DELETE')

            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    @endcanany

@endsection
