export interface Author {
  firstName: string;
  lastName: string;
}

export interface Category {
  name: string;
}

export interface BookDTO {
  bookId: number;
  title: string;
  description: string;
  authors: Author[];
  categories: Category[];
}

export interface RentalDTO {
  rentalId: number;
  rentalDate: string;
  dueDate: string;
  returnDate: string | null;
  status: RentalStatus;
  copy: CopyDTO;
  libraryUser: LibraryUserDTO;
}

export enum RentalStatus {
  RESERVED = 'RESERVED',
  RENTED = 'RENTED',
  RETURNED = 'RETURNED',
  PENALTY = 'PENALTY',
}

export interface CopyDTO {
  copyId: number;
  name: string;
  book: BookDTO
}


export interface AddressDTO {
  street: string;
  number: string;
  city: string;
  zipcode: string;
}

export interface AddressDTO {
  street: string;
  number: string;
  city: string;
  zipcode: string;
}

export interface NewBookDTO {
  title: string;
  description: string;
  authors: Author[];
  categories: Category[];
}

export interface LibraryUserDTO {
  id?: number;
  username: string;
  password: string;
  repeatPassword: string;
  firstName: string;
  lastName: string;
  email: string;
  address: {
    street: string;
    number: string;
    city: string;
    zipcode: string;
  };
  phoneNumber: string; // Add the phoneNumber property
}