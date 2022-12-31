# from django.urls import path
# from . import views

# urlpatterns = [
#     path("books", views.books),
#     path("orders", views.Orders.listOrders),
#     path("items/<int:pk>", views.BookView.as_view()),
#     path('books2', views.BookView2.as_view(
#         {
#             'get': 'list',
#             'post': 'create',
#         }
#     )),
#     path('books2/<int:pk>', views.BookView2.as_view(
#         {
#             'get': 'retrieve',
#         }
#     ))
# ]

from rest_framework.routers import SimpleRouter, DefaultRouter
from . import views
# router = SimpleRouter(trailing_slash=False)
router = DefaultRouter(trailing_slash=False)
router.register("books", views.BookView2, basename="books")
urlpatterns = router.urls
