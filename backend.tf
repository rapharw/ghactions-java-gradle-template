terraform {
  backend "azurerm" {
    resource_group_name  = "rg-your-solution-001-poc"
    storage_account_name = "sayourstorageaccount001poc"
    container_name       = "containername001poc"
    key                  = "terraform.tfstate"
  }
}