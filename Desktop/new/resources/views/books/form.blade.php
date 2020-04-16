{{--book name--}}
<div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label @error('name') text-danger @enderror">Name</label>
    <div class="col-sm-5">
        <input type="text" class="form-control @error('name') is-invalid @enderror" id="name" name="name" value="{{ old('name') ?? $book->name ?? null }}">
        @error('name')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Loai sach--}}
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Chọn Loai Sach</label>
    <div class="col-sm-5">
        <select class="browser-default custom-select mr-sm-0" name="loaisach_id">
            @foreach(\App\Models\Loaisach::pluck('name', 'id')->toArray() as $key => $value)
                <option value="{{ $key }}" {{ ((old('loaisach_id') ?? $book->loaisach_id ?? 0) == $key) ? 'selected' : '' }}>{{ $value }}</option>
            @endforeach
        </select>
    </div>
</div>

{{--describe--}}
<div class="form-group row">
    <label class="col-sm-2 col-form-label @error('desc') text-danger @enderror">Describe</label>
    <div class="col-sm-5">
        <textarea class="form-control @error('desc') is-invalid @enderror" id="article-ckeditor" name="desc">{{ old('desc') ?? $book->desc ?? null }}</textarea>
        @error('desc')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--image--}}
<div class="form-group row">
    <label for="image" class="col-md-2 col-form-label">Book Image</label>
    <div class="col-md-5">
        <input id="image" type="file" name="image">
{{--        @if ($book->image)--}}
{{--            <code>{{ $book->image }}</code>--}}
{{--        @endif--}}
    </div>
</div>
