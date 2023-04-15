package org.si.projetintegsi.web;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MyContract {
  /*private final Web3j web3j;
  private final TransactionManager transactionManager;
  private final BigInteger gasPrice;
  private final BigInteger gasLimit;
  private final String contractAddress;
  private MyContractInterface contractInterface;

  public MyContract(String rpcUrl, String privateKey, String contractAddress) {
    web3j = Web3j.build(new HttpService(rpcUrl));
    transactionManager = new ClientTransactionManager(web3j, privateKey);
    gasPrice = BigInteger.valueOf(20000000000L);
    gasLimit = BigInteger.valueOf(6721975L);
    this.contractAddress = contractAddress;
    contractInterface = MyContractInterface.load(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
  }

  public void addPoint(Point point) throws ExecutionException, InterruptedException {
    contractInterface.addPoint(new Uint256((long) point.getX()), new Uint256((long) point.getY())).sendAsync().get();
  }

  public List<Point> getPoints() throws ExecutionException, InterruptedException {
    List<Type> result = contractInterface.getPoints().sendAsync().get().getValue();
    List<Point> points = new ArrayList<>();
    for (Type type : result) {
      Uint256[] values = (Uint256[]) type.getValue();
      Point point = new Point(values[0].getValue().intValue(), values[1].getValue().intValue());
      points.add(point);
    }
    return points;
  }

  public static void deployContract() throws Exception {
    String rpcUrl = "http://localhost:7545"; // URL du nœud Ethereum
    String privateKey = "private_key_here"; // Clé privée du compte utilisé pour déployer le contrat
    String contractAddress = "contract_address_here"; // Adresse du contrat déjà déployé

    MyContract myContract = new MyContract(rpcUrl, privateKey, contractAddress);

    // Ajouter un nouveau point à la liste de points
    Point newPoint = new Point(10, 20);
    myContract.addPoint(newPoint);

    // Récupérer la liste de points
    List<Point> points = myContract.getPoints();
    System.out.println("Liste de points: " + points);
  }*/
}
