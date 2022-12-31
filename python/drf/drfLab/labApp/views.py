from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status
from rest_framework.decorators import api_view

# Create your views here.

# * Function-based views


@api_view()
def books(request):
    return Response("list of books", status=status.HTTP_200_OK)


# * Class-based views


class Orders():
    @staticmethod
    @api_view()
    def listOrders(request):
        return Response({"message": "list of orders"}, 200)
