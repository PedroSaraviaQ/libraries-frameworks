from django.urls import path
from . import views

urlpatterns = [
    path("books", views.books),
    path("orders", views.Orders.listOrders),
    path("items/<int:pk>", views.BookView.as_view()),
    path('books2', views.BookView2.as_view(
        {
            'get': 'list',
            'post': 'create',
        }
    )),
    path('books2/<int:pk>', views.BookView2.as_view(
        {
            'get': 'retrieve',
        }
    ))
]
