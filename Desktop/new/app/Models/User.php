<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Illuminate\Support\Facades\Hash;

class User extends Authenticatable
{
    use Notifiable;

    protected $table = 'users';
    public $primaryKey = 'id';
    public $timestamps = true;

    protected $perPage = 10;

    protected $fillable = [
        'user_name',
        'password',
        'name',
        'address',
        'phone',
        'role',
    ];

    protected $hidden = [
        'password', 'remember_token',
    ];

    /**
     * The attributes that should be cast to native types.
     *
     * @var array
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];

    const ADMIN = 1;
    const STAFF = 2;
    const GUESS = 3;

    public static $roles = [
        self::ADMIN => 'Quản trị viên',
        self::STAFF => 'Nhân viên',
        self::GUESS => 'Người dùng',
    ];

    /**
     * Scope a query to find userName.
     *
     * @param \Illuminate\Database\Eloquent\Builder $query
     * @param string $userName
     * @return \Illuminate\Database\Eloquent\Builder
     */
    public function scopeFindUserName($query, $userName)
    {
        return $query->where('user_name', 'like', '%' . $userName . '%');
    }

    /**
     * Scope a query to find name.
     *
     * @param \Illuminate\Database\Eloquent\Builder $query
     * @param string $name
     * @return \Illuminate\Database\Eloquent\Builder
     */
    public function scopeFindName($query, $name)
    {
        return $query->where('name', 'like', '%' . $name . '%');
    }

    /**
     * Scope a query to find address.
     *
     * @param \Illuminate\Database\Eloquent\Builder $query
     * @param string $address
     * @return \Illuminate\Database\Eloquent\Builder
     */
    public function scopeFindAddress($query, $address)
    {
        return $query->where('address', 'like', '%' . $address . '%');
    }

    /**
     * Scope a query to find phone.
     *
     * @param \Illuminate\Database\Eloquent\Builder $query
     * @param string $phone
     * @return \Illuminate\Database\Eloquent\Builder
     */
    public function scopeFindPhone($query, $phone)
    {
        return $query->where('phone', $phone);
    }

    /**
     * get users info ascending sort by user_name
     *
     * @param array $data
     * @return \Illuminate\Pagination\Paginator
     */
    public function getUsers($data)
    {
        $builder = $this->orderBy('user_name');

        if (isset($data['user_name'])) {
            $builder->findUserName($data['user_name']);
        }
        if (isset($data['name'])) {
            $builder->findName($data['name']);
        }
        if (isset($data['address'])) {
            $builder->findAddress($data['address']);
        }
        if (isset($data['phone'])) {
            $builder->findPhone($data['phone'])->get();
        }

        return $builder->paginate();
    }

    /**
     * save  user to database
     *
     * @param \App\Http\Requests\StoreUserRequest $request
     * @return User
     */
    public function saveUser($request)
    {
        $data = $request->all();
        $data['password'] = Hash::make($data['password']);
        return $this->create($data);
    }

    /**
     * update user in database
     *
     * @param StoreUserRequest $request
     * @return boolean
     */
    public function updateUser($request)
    {
        $data = $request->all();

        if ($data['password']) {
            $data['password'] = Hash::make($data['password']);
        } else {
            unset($data['password']);
        }

        return $this->find($request->id)->update($data);
    }

    /**
     * delete user from database
     *
     * @param integer $id
     * @return bool
     */
    public function deleteUser($id)
    {
        $user = $this->find($id);
        if (!isset($user)) {
            return false;
        }

        return $user->delete();
    }

}
