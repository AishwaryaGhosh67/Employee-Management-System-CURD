import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () => axios.get(REST_API_BASE_URL + `/getAllEmp`);

export const createEmployee = (employee) => axios.post(REST_API_BASE_URL + `/createEmp`, employee);

export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL + `/getEmp/` + employeeId);

export const updateEmployee = (employeeId, employee) => axios.put(REST_API_BASE_URL + `/updateEmp/` + employeeId, employee);

export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL + `/deleteEmp/` + employeeId);