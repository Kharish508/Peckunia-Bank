add acount:
 http://localhost:8090/transaction/create
POSTMAN (Post : body{ "customer_name": "Ramesh", "amount": 50000.0, "contact_number": "97000000"}
dont insert id ,  id is  :@GeneratedValue(strategy = GenerationType.SEQUENCE)

creditUsingSlip:
 http://localhost:8090/transaction/creditUsingSlip/181/1000

debitUsingSlip
 http://localhost:8090/transaction/debitUsingSlip/181/2000
  