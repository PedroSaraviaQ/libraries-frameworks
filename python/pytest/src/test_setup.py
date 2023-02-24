#
# * Install and import the "pytest" package
# * Files should start with "test_" or end with "_test"
import pytest


def sum(a, b):
    return a + b


# * Functions should start with "test"
def test_sum():

    # * Use "assert" to test expectations
    assert sum(2, 5) == 7


# * Classes should start with "Test"
class TestGroup:
    def test_length(self):
        assert len("purple") == 4

    def test_includes(self):
        assert 3 in [1, 2, 3, 4, 5]
