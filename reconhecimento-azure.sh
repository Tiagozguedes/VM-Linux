#!/bin/bash

echo "*************************************"
echo "Bem-vindo à Missão DimDim nas Nuvens!"
echo "*************************************"
echo ""

# 1. Verificar versão do Azure CLI
echo "=== 1. Verificando versão do Azure CLI ==="
az --version
echo ""

# 2. Listar assinaturas
echo "=== 2. Listando assinaturas disponíveis ==="
az account list -o table
echo ""

# 2.2 Exibir assinatura corrente
echo "=== 2.2 Assinatura ativa ==="
az account show --query "{Sub:id, Nome:name}" -o jsonc
echo ""

# 2.3 Listar regiões
echo "=== 2.3 Regiões disponíveis ==="
az account list-locations -o table
echo ""

# 2.4 Filtrar regiões ordenadas
echo "=== 2.4 Nomes das regiões ordenados ==="
az account list-locations --query "[].name" -o tsv | sort
echo ""

# 3. Criar grupo de recursos
echo "=== 3. Criando grupo de recursos ==="
az group create --name rg-dimdim-dev --location eastus
echo ""

# 3.2 Verificar grupo criado
echo "=== 3.2 Verificando grupo de recursos ==="
az group show -n rg-dimdim-dev --query "{Name:name, Local:location, Tags:tags}"
echo ""

# 4. Listar imagens Ubuntu LTS
echo "=== 4.1 Listando imagens Ubuntu LTS ==="
az vm image list --offer "server-focal" --publisher canonical --sku "20_04-lts" --all -o table
echo ""

# 4.3 Listar tamanhos de VM
echo "=== 4.3 Tamanhos de VM disponíveis em East US ==="
az vm list-sizes --location eastus -o table
echo ""

# 4.3 Filtrar SKUs Standard_B
echo "=== 4.3 SKUs Standard_B em East US ==="
az vm list-skus --location eastus --resource-type virtualMachines --size "Standard_B" -o table
echo ""

echo "*************************************"
echo "Reconhecimento concluído!"
echo "*************************************"
