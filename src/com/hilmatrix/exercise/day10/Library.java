package com.hilmatrix.exercise.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Library {
    private List<LibraryMaterial> materialList;
    private List<String> materialListByID;

    public List<LibraryMaterial> getMaterialList() {
        return materialList;
    }

    public List<String> getMaterialListByID() {
        return materialListByID;
    }

    public Library() {
        materialList = new ArrayList<>();
        materialListByID = new ArrayList<>();
    }

    public void addBook(String title, String author, String date, String[] contents, int copies) {
        if (copies < 1)
            return;

        String materialID = UUID.randomUUID().toString();
        materialListByID.add(materialID);
        for (int loop = 0; loop < copies; loop++) {
            Book book = new Book(UUID.randomUUID().toString(), materialID, title, author, date, contents);
            materialList.add(book);
        }
    }

    public int countMaterialByID(String materialID) {
        int sum = 0;
        for (LibraryMaterial material : materialList) {
            if (materialID.equals(material.getMaterialID())) {
                if (material.isAvailable())
                    sum++;
            }
        }
        return sum;
    }

    public List<LibraryMaterial> getAllSampleMaterial() {
        List<LibraryMaterial> result = new ArrayList<LibraryMaterial>();
        for (String materialID : materialListByID) {
            for (LibraryMaterial material : materialList) {
                if (materialID.equals(material.getMaterialID())) {
                    result.add(material);
                    break;
                }
            }
        }
        return result;
    }

    public void borrowMaterial(int index) {
        String materialID = materialListByID.get(index);
        boolean success = false;

        for (LibraryMaterial material : materialList) {
            if (material.getMaterialID().equals(materialID) && material.isAvailable()) {
                material.borrow();
                System.out.println("Borrowed a material. ID = " + material.getLibraryID());
                success = true;
                break;
            }
        }
        if (!success) {
            System.out.println("Failed to borrow material, no copies left");
        }
    }

    public void returnMaterial(int index) {
        List<LibraryMaterial>  borrowedMaterials = listAllBorrowedMaterials();
        LibraryMaterial borrowedMaterial = borrowedMaterials.get(index);
        borrowedMaterial.returnMaterial();
        System.out.println("Returned material with library ID " + borrowedMaterial.getLibraryID());
    }

    public List<LibraryMaterial> listAllBorrowedMaterials() {
        List<LibraryMaterial> result = new ArrayList<LibraryMaterial>();
        for (LibraryMaterial material : materialList) {
            if (!material.isAvailable()) {
                result.add(material);
            }
        }
        return result;
    }
}
