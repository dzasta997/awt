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




