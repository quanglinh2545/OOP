@extends('layouts.default')

@section('title', 'Book list')

@section('content')
    @include('flash::message')

    <h1>Books</h1>
    @if(count($books)>0)
        @foreach($books as $key => $book)
            <div class="card card-body bg-light">
                <div class="row">
                    <div class="col-md-4 col-sm-4">
                        <a href="/books/{{$book->id}}">
                            @if($book->image)
                                <img style="width: 100%" src="/storage/book_images/{{ $book->image }}">
                            @else
                                <img style="width: 100%" src="/img/no_image.jpg">
                            @endif
                        </a>
                    </div>

                    <div class="col-md-8">
                        <div>
                            <h3>{{ $books->firstItem() + $key }} . <a href="/books/{{$book->id}}"> {{ $book->name }}</a>
                            </h3>
                            <p> DESCRIBE: {!! substr($book->desc,0,100) . '...' !!}</p>
                            <small>update on {{ $book->created_at }}</small>
                        </div>
                    </div>
                </div>
            </div>
            <br>
        @endforeach
    @endif
    {!! $books->links() !!}


@endsection
