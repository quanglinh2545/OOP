{{--user name--}}
<div class="form-group row">
    <label for="user-name" class="col-sm-2 col-form-label @error('user_name') text-danger @enderror">User Name</label>
    <div class="col-sm-5">
        <input type="text" class="form-control @error('user_name') is-invalid @enderror" id="user-name" name="user_name" value="{{ old('user_name') ?? $user->user_name ?? null }}">
        @error('user_name')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Mật khẩu--}}
<div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label @error('password') text-danger @enderror">Mật khẩu</label>
    <div class="col-sm-5">
        <input type="password" class="form-control @error('password') is-invalid @enderror" id="password" name="password">
        @error('password')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Mật khẩu xác nhận--}}
<div class="form-group row">
    <label for="password-confirmation" class="col-sm-2 col-form-label @error('password_confirmation') text-danger @enderror">Mật khẩu xác nhận</label>
    <div class="col-sm-5">
        <input type="password" class="form-control @error('password_confirmation') is-invalid @enderror" id="password-confirmation" name="password_confirmation">
        @error('password_confirmation')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Tên--}}
<div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label @error('name') text-danger @enderror">Tên</label>
    <div class="col-sm-5">
        <input type="text" class="form-control @error('name') is-invalid @enderror" id="name" name="name" value="{{ old('name') ?? $user->name ?? null }}">
        @error('name')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Địa chỉ--}}
<div class="form-group row">
    <label for="address" class="col-sm-2 col-form-label @error('address') text-danger @enderror">Địa chỉ</label>
    <div class="col-sm-5">
        <input type="text" class="form-control  @error('address') is-invalid @enderror" id="address" name="address" value="{{ old('address') ?? $user->address ?? null }}">
        @error('address')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--Số điện thoại--}}
<div class="form-group row">
    <label for="phone" class="col-sm-2 col-form-label @error('phone') text-danger @enderror">Số điện thoại</label>
    <div class="col-sm-5">
        <input type="tel" class="form-control @error('phone') is-invalid @enderror" id="phone" name="phone" value="{{ old('phone') ?? $user->phone ?? null }}">
        @error('phone')
        <div class="text-danger">{{ $message }}</div>
        @enderror
    </div>
</div>

{{--role--}}
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Chọn quyền</label>
    <div class="col-sm-5">
        <select class="browser-default custom-select" name="role">
            @php
                $roles = \App\Models\User::$roles;
            @endphp

            @foreach($roles as $key => $value)
                <option value="{{ $key }}" {{ ((old('role') ?? $user->role ?? 0) == $key) ? 'selected' : '' }}>{{ $value }}</option>
            @endforeach
        </select>
    </div>
</div>
