<?php

namespace App\Http\Controllers;

use App\Models\Product;
use App\Http\Requests\StoreProductRequest;
use App\Http\Requests\UpdateProductRequest;

class ProductController extends Controller
{

    public function index()
    {
        return Product::all();
    }

    public function store(StoreProductRequest $request)
    {
        $data = Product::create($request->all());
        return $data;
    }

    public function show(Product $product)
    {
        return $product;
    }

    public function update(UpdateProductRequest $request, Product $product)
    {
        $product->update($request->all());
    }

    public function destroy(Product $product)
    {
        $product->delete();
        return response([], 200);
    }
}
