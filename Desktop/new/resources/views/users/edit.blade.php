@extends('layouts.default')

@section('title', 'Cập nhật người dùng')

@section('content')
    <div class="container">
        <br>
        <h3>Cập nhật</h3>
        <form action="{{ route('users.update', $user->id) }}" method="post">
            @csrf
            @method('PUT')
            <input type="hidden" name="id" value="{{ $user->id }}">
            @include('users.form')

            <div class="form-group">
                <button type="submit" class="btn btn-primary">Cập nhật</button>
            </div>
        </form>
    </div>
@endsection
