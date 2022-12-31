from django.shortcuts import render
from rest_framework.response import Response
from rest_framework import status, viewsets
from rest_framework.decorators import api_view
from rest_framework.views import APIView

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


# * Class extending "APIView"


class BookView(APIView):
    def get(self, request, pk):
        return Response({"message": "single book with id " + str(pk)}, status.HTTP_200_OK)


# * Class extending "viewsets.ViewSet"


class BookView2(viewsets.ViewSet):
    def list(self, request):
        return Response({"message": "All books"}, status.HTTP_200_OK)

    def create(self, request):
        return Response({"message": "Creating a book"}, status.HTTP_201_CREATED)

    def retrieve(self, request, pk=None):
        return Response({"message": "Displaying a book"}, status.HTTP_200_OK)
