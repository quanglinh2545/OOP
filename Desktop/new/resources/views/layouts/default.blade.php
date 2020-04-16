<html>
@include('layouts.head')
<body>
@include('layouts.header')

<div class="container">
    @yield('content')
</div>

{{--@include('layouts.footer')--}}

<script src="/vendor/unisharp/laravel-ckeditor/ckeditor.js"></script>
<script>
    CKEDITOR.replace('article-ckeditor');
</script>
</body>
</html>
