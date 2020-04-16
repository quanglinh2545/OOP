@extends('layouts.admin')

@section('title', 'Thêm mới người dùng')

@section('content')
    <br>
    <h3>Đăng ký</h3>
    <form action="{{ route('users.store') }}" method="post">
        @csrf
        @include('users.form')
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Đăng ký</button>
        </div>
    </form>
@endsection
