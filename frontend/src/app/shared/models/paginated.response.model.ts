export interface PaginatedResponse<Model> {
  content: Model[];
  totalElements: number;
}
