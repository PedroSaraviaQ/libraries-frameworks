from django.urls import path
from . import views

urlpatterns = [
    path("books", views.books),
    path("orders", views.Orders.listOrders),
    path("items/<int:pk>", views.BookView.as_view())
]
